$(function() {
    App.Dialog = {

        window: {
            element: $("#dialogWindow"),
            open: function (content, title) {
                this.setTitle(title);
                this.element.dialog("close");
                this.element.html(content);
                this.element.dialog("open");
            },
            close: function() {
                this.element.dialog("close");
            },
            setTitle: function(title) {
                if (title !== undefined) {
                    this.element.dialog("option", "title", title);
                }
            }
        },
        error: {
            element: $("#dialogError"),
            open: function (message) {
                this.element.html(message);
                this.element.dialog("open");
            },
            close: function() {
                this.element.dialog("close");
            }
        },
        message: {
            onCloseAction : null,
            element: $("#dialogMessage"),
            open: function (message) {
                this.element.html(message);
                this.element.dialog("open");
            },
            close: function() {
                this.element.dialog("close");
            }
        },
        warning: {
            element: $("#dialogWarning"),
            open: function (message) {
                this.element.html(message);
                this.element.dialog("open");
            },
            close: function() {
                this.element.dialog("close");
            }
        },
        warningSave: {
            element: $("#dialogWarningSave"),
            open: function (message) {
                this.element.html(message);
                this.element.dialog("open");
            },
            close: function() {
                this.element.dialog("close");
            }
        },

        init: function () {
            App.Dialog.window.element.dialog({
                height: "auto",
                width: "auto",
                autoOpen: false,
                position: {
                    my: "center",
                    at: "center",
                    of: window
                },
                close: function (event, ui) {
                    // Clear the content
                    App.Dialog.window.element.html('');
                }
            });
            App.Dialog.message.element.dialog({
                height: 200,
                width: 350,
                autoOpen: false,
                title: "Сообщение",
                position: {
                    my: "center",
                    at: "center",
                    of: window
                },
                buttons: {
                    "OK" : function() {
                        App.Dialog.message.close();
                    }
                },
                close: function() {
                    if (App.Dialog.message.onCloseAction && typeof App.Dialog.message.onCloseAction == 'function')
                        App.Dialog.message.onCloseAction();
                    App.Dialog.message.onCloseAction = null;
                }
            });
            App.Dialog.error.element.dialog({
                height: 200,
                width: 350,
                autoOpen: false,
                title: "Ошибка",
                position: {
                    my: "center",
                    at: "center",
                    of: window
                },
                buttons: {
                    "OK" : function() {
                        App.Dialog.error.close();
                    }
                }
            });
            App.Dialog.warning.element.dialog({
                height: 200,
                width: 350,
                autoOpen: false,
                title: "Предупреждение",
                position: {
                    my: "center",
                    at: "center",
                    of: window
                },
                buttons: {
                    "Да" : function() {
                        App.Dialog.warning.close();
                    },
                    "Нет" : function() {
                        App.Dialog.warning.close();
                    }
                }
            });
            App.Dialog.warningSave.element.dialog({
                height: 200,
                width: 350,
                autoOpen: false,
                title: "Предупреждение",
                position: {
                    my: "center",
                    at: "center",
                    of: window
                },
                buttons: {
                    "Сохранить" : function() {
                        App.Dialog.warningSave.close();
                    },
                    "Не сохранять" : function() {
                        App.Dialog.warningSave.close();
                    },
                    "Отмена" : function() {
                        App.Dialog.warningSave.close();
                    }
                }
            });
        }
    };

    App.Dialog.init();
});