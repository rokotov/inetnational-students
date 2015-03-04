var Module = (function () {
    var report = {};
    var months =["январь"
                ,"февраль"
                ,"март"
                ,"апрель"
                ,"май"
                ,"июнь"
                ,""
                ,""
                ,""
                ,""
                ,""
                ,""
    ];
    report.drawMonth = function(monthNum){
          return months[monthNum];
    };



    return report;

})();