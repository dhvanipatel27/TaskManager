(function () {
    app.factory("ConfigVarSvc", function ($http) {

        return {
            getSelectOptions: getSelectOptions
        }

        function getSelectOptions(){
          var selectOptions = {
            "priority": ['Low', 'Medium', 'High'],
            "type": ['H1B', 'H1B Cap', 'H1B Ammendment'],
            "processing_by": ['Internal Filing', 'Attorney'],
            "employee_name": ['Employee 1', 'Employee 2', 'Employee 3'],
            "task_subject": ['Project Change', 'H1B CAP'],
            "requested_by": ['Sales', 'Immigration', 'Client'],
            "task_owner": ['Internal 1'],
            "status": ['Submitted', 'Denied', 'In Process', 'Approved'],
             };
             return selectOptions;
        }

        
    });
})();