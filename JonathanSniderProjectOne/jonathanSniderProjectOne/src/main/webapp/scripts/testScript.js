function populateEmployees()
{
    fetch("http://localhost:7001/jonathanSniderProjectOne/employeeGetter").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		console.log(data);
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/jonathanSniderProjectOne/welcomePage";
        }
        else 
		{

            employeeList=data;
            employeeHolder=document.getElementById("employeeList");
            for(let i=0;i<employeeList.length;i++)
            {
                let tableRow = document.createElement("tr");
            employeeHolder.appendChild(tableRow);

            let IdElement=document.createElement("td");
            tableRow.appendChild(IdElement);

            let id=employeeList[i].EmployeeId;
            let idText = document.createTextNode(id);
            IdElement.appendChild(idText);

            let firstNameElement=document.createElement("td");
            tableRow.appendChild(firstNameElement);

            let firstNameValue=employeeList[i].firstName;
            let firstNameText = document.createTextNode(firstNameValue);
            firstNameElement.appendChild(firstNameText);

            let lastNameElement=document.createElement("td");
            tableRow.appendChild(lastNameElement);

            let lastNameValue=employeeList[i].lastName;
            let lastNameText = document.createTextNode(lastNameValue);
            lastNameElement.appendChild(lastNameText);

            let managerElement=document.createElement("td");
            tableRow.appendChild(managerElement);

            let managerValue=employeeList[i].reportsTo;
            let managerText = document.createTextNode(managerValue);
            managerElement.appendChild(managerText);

            let isManagerElement=document.createElement("td");
            tableRow.appendChild(isManagerElement);

                if(employeeList[i].isManager)
                {

                    let isManagerText = document.createTextNode("Manager Access");
                    isManagerElement.appendChild(isManagerText);
                }
                else
                {
            let isManagerText = document.createTextNode("No Manager Access");
            firstNameElement.appendChild(isManagerText);
                }

                let jobElement=document.createElement("td");
                tableRow.appendChild(jobElement);

                let jobValue=employeeList[i].jobTitle;
                let jobText = document.createTextNode(jobValue);
                managerElement.appendChild(jobText);
                
                let userElement=document.createElement("td");
                tableRow.appendChild(userElement);

                let userValue=employeeList[i].logInUsername;
                let userText = document.createTextNode(userValue);
                managerElement.appendChild(userText);

                let passwordElement=document.createElement("td");
                tableRow.appendChild(passwordElement);

                let passwordValue=employeeList[i].logInPassword;
                let passwordText = document.createTextNode(passwordValue);
                managerElement.appendChild(passwordText); 
            }
        }
    });
}