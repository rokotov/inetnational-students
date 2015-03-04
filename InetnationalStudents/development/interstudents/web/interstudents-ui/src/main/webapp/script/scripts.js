$(function() {

    $.datepicker.regional['ru'] = {
        closeText: 'Закрыть',
        prevText: '&#x3c;Пред',
        nextText: 'След&#x3e;',
        currentText: 'Сегодня',
        monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь',
            'Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
        monthNamesShort: ['Янв','Фев','Мар','Апр','Май','Июн',
            'Июл','Авг','Сен','Окт','Ноя','Дек'],
        dayNames: ['воскресенье','понедельник','вторник','среда','четверг','пятница','суббота'],
        dayNamesShort: ['вск','пнд','втр','срд','чтв','птн','сбт'],
        dayNamesMin: ['Вс','Пн','Вт','Ср','Чт','Пт','Сб'],
        weekHeader: 'Не',
        dateFormat: 'dd.mm.yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''};
    $.datepicker.setDefaults($.datepicker.regional['ru']);

    $('.dateInput').each(function(){
        $(this).datepicker();
    });

    $("ul.fancy_list > li").each(function(){
        $(this).addClass('collapsed');
    });

    $('.searchFilterToggle').on('click', function() {
        $(this).parent().find('.searchFilter').toggle();
    });

    $('body').on('click', '.popupContent', function(event) {
        event.preventDefault();
        App.Dialog.window.setTitle($(this).attr('title'));
        var url = $(this).attr('href');
        $.ajax({
            type: 'GET',
            url: url,
            success: ajaxPopupReceived
        });
    });

    $('body').on('click', '.rightContent', function(event) {
        event.preventDefault();
        var url = $(this).attr('href');
        $.ajax({
            type: 'GET',
            url: url,
            success: ajaxRightReceived
        });
    });

    $('.userMenu select').on('change', function() {
        var href = $(this).val();
        window.location.href = href;
    });

    $('body').on('submit', '#dialogWindow form', function(event) {
        event.preventDefault();
        var url = $(this).attr('action');
        $.ajax({
            type: 'POST',
            url: url,
            data: $(this).serialize(),
            success: ajaxPopupReceived
        });
    });

    $('body').on('submit', '#right-region form', function(event) {
        event.preventDefault();
        var url = $(this).attr('action');
        $.ajax({
            type: 'POST',
            url: url,
            data: $(this).serialize(),
            success: ajaxRightReceived
        });
    });

    $('body').on('click', '#dialogWindow input[type=reset], #dialogWindow button[type=reset]', function(event){
        App.Dialog.window.close();
        event.preventDefault();
    });

    $('.scheduleSwitcher').on('click', function() {
        if ($(this).hasClass('active'))
            return;

        $('.scheduleSwitcher.active').removeClass('active');
        $('.scheduleType.active').removeClass('active');

        $(this).addClass('active');
        $('.scheduleType[data-type=' + $(this).data('type') + ']').addClass('active');
    });

    $('body').on('click', '.fancy_list .expanded > p', function(event) {
        event.preventDefault();
        $(this).parent().removeClass('expanded').addClass('collapsed');
    });
    $('body').on('click', '.fancy_list .collapsed > p', function(event) {
        event.preventDefault();
        $(this).parent().removeClass('collapsed').addClass('expanded');
    });

    $('body').on('click', '#right-region .cancelForm', function() {
        $('#right-region').html('');
    });

    $('body').on('click', '#vacationTable tr', function(event) {

        $('#vacationTable tr.info').removeClass('info');
        $(this).addClass('info');
        event.preventDefault();
        var url = $(this).data('href');
        $.ajax({
            type: 'GET',
            url: url,
            success: ajaxRightReceived
        });
    });

    $('body').on('click', '.addPeriod', function(event) {
        event.preventDefault();
        var $periodInputs = $(this).closest(".periodInputs");
        var $template = $periodInputs.find('.periodInput.addingTemplate').clone();
        $template.insertBefore($(this));
        $template.removeClass('addingTemplate');
        $template.find('.dateInput').each(function() {
            $(this).removeAttr("id").removeClass('hasDatepicker').datepicker();
        });
        var index = $periodInputs.data('index');
        var prefix = $periodInputs.data('prefix');
        if (!prefix)
            prefix = '';
        $template.find('.startDate').attr('name', prefix + 'periods[' + index + '].startDate');
        $template.find('.endDate').attr('name', prefix + 'periods[' + index + '].endDate');
        $periodInputs.data("index", index + 1);

    });

    $('body').on('click', '.removePeriod', function(event) {
        event.preventDefault();

        var template = $(this).parent(".periodInput").remove();
    });

    $('body').on('click', '.schedule-scroll', function(event) {
        event.preventDefault();

        $('#inputScheduleShift').val($(this).data('shift'));
        $('form#vacationSearchForm').submit();
    });

    $('body').on('click', '.schedule-month-scroll', function(event) {
        event.preventDefault();
        $('#inputScheduleShift').val($(this).data('shift'));
        $('#viewTypeMonth').prop('checked', true);
        $('form#vacationSearchForm').submit();
    })

    // Submit Schedule Charts on ViewType chage
    $('body').on('change', '#viewTypeMonth, #viewTypeYear', function() {
        $('form#vacationSearchForm').submit();
    });
});

$(function() {
    $('body').on('click', '#workflowForm .addFirst', function(event) {
        event.preventDefault();
        var approversInputs = $(this).closest(".approversInputs");
        var $template = approversInputs.find('.approverInput.addingFirstTemplate').clone();
        $template.insertBefore($(this).closest('li'));
        $template.removeClass('addingFirstTemplate');

        $template.find('.titleSelect').each(function() {
            $(this).removeAttr("id");
        });
        $template.find('.employeeSelect').each(function() {
            $(this).removeAttr("id");
        });

        var index = approversInputs.data('indexbeforerm');
        var prefix = approversInputs.data('prefix');
        if (!prefix)
            prefix = '';
        $template.find('.employeeSelect').attr('name', prefix + 'first[' + index + '].employeeId');

        approversInputs.data("indexbeforerm", index + 1);
    });

    $('body').on('click', '#workflowForm .removeFirst, #workflowForm .removeSecond', function(event) {
        event.preventDefault();

        var template = $(this).closest(".approverInput").remove();
    });

    $('body').on('click', '#workflowForm .addSecond', function(event) {
        event.preventDefault();
        var $approverInputs = $(this).closest(".approversInputs");
        var $template = $approverInputs.find('.approverInput.addingSecondTemplate').clone();
        $template.insertBefore($(this).closest('li'));
        $template.removeClass('addingSecondTemplate');

        $template.find('.titleSelect').each(function() {
            $(this).removeAttr("id");
        });
        $template.find('.employeeSelect').each(function() {
            $(this).removeAttr("id");
        });

        var index = $approverInputs.data('indexafterrm');
        var prefix = $approverInputs.data('prefix');
        if (!prefix)
            prefix = '';
        $template.find('.employeeSelect').attr('name', prefix + 'second[' + index + '].employeeId');

        $approverInputs.data("indexafterrm", index + 1);
    });

    $('body').on('change', '#workflowForm .titleSelect', function() {
        var titleId = $(this).val();
        if (titleId == "") {
            $(this).closest('.form-group').find('select.employeeSelect option').show();
            return;
        }

        $(this).closest('.form-group').find('select.employeeSelect option').each(function() {
            if ($(this).data('title') == titleId || $(this).data('title') === undefined) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });
});


function ajaxPopupReceived(data) {
    if (typeof data === 'object') {
        switch (data.status) {
            case 'ok':
                App.Dialog.window.close();
                App.Dialog.message.open("Действие выполнено успешно");
                if (data.reload)
                    App.Dialog.message.onCloseAction = function() {
                        window.location = window.location.href;
                    }
                break;
            case 'error':
                if (data.message !== 'undefined') {
                    App.Dialog.error.open(data.message);
                } else {
                    App.Dialog.error.open("Unknown Error");
                }
                break;
        }
    } else {
        App.Dialog.window.open(data);
        // Apply datepicker to received form
        App.Dialog.window.element.find(".dateInput").each(function () {
            $(this).datepicker();
        });
    }
}


function ajaxRightReceived(data) {

    if (typeof data === 'object') {
        switch (data.status) {
            case 'ok':
                $("#right-region").html('');
                App.Dialog.message.open("Действие выполнено успешно");
                if (data.reload)
                    App.Dialog.message.onCloseAction = function() {
                        window.location = window.location.href;
                    }
                break;
            case 'error':
                if (data.message !== 'undefined') {
                    App.Dialog.error.open(data.message);
                } else {
                    App.Dialog.error.open("Unknown Error");
                }
                break;
        }
    } else {
        $("#right-region").html(data);
        // Apply datepicker to received form
        $("#right-region .dateInput").each(function(){
            $(this).datepicker();
        });
    }
}