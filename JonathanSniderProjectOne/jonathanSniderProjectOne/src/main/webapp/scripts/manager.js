window.onload = function(){
    populateReimbursementsManager();
    populateReimbursementsResolved();
    populateEmployees();
}

function populateReimbursementsManager(){
    fetch("http://localhost:7001/jonathanSniderProjectOne/managerFunctions").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		console.log(data);
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/jonathanSniderProjectOne/welcomePage";
		} else 
		{
			reimbursementData=data;
        console.log(reimbursementData);
        for(let i=0;i<reimbursementData.length;i++)
        {
            if(reimbursementData[i].decidingManagerId==0)
            {
                let FormHolder=document.createElement("form");
                //FormHolder.setAttribute("class","form-signin")
                FormHolder.setAttribute("action","managerFunction")
                FormHolder.setAttribute("method","post")


                let approveButton=document.createElement("button");
                FormHolder.appendChild(approveButton);
                approveButton.setAttribute("type","submit");
                approveButton.setAttribute("name","approveReim");
                approveButton.setAttribute("id","approveButton");
                approveButton.style.margin="10px";
                approveButton.innerHTML="approve";
                
                let denyButton=document.createElement("button");
                FormHolder.appendChild(denyButton);
                denyButton.setAttribute("type","submit");
                denyButton.setAttribute("name","denyReim");
                denyButton.setAttribute("id","denyButton");
                denyButton.style.margin="10px";
                denyButton.innerHTML="deny";

                let boxHolder=document.createElement("div");
                boxHolder.setAttribute("class", "boxMaker");
                document.getElementById("decisionList").appendChild(boxHolder);
                let nameText = document.createTextNode("Submitting Employee: "+reimbursementData[i].employee.firstName+" "+ reimbursementData[i].employee.lastName+" Reimbursement id: "+reimbursementData[i].reimbursementId+" Reimbursement Reason: "+reimbursementData[i].reimbursementName+" Reimbursement Amount: "+reimbursementData[i].reimbursementAmount);
                boxHolder.appendChild(nameText);
                boxHolder.appendChild(FormHolder);
                let br = document.createElement("br");
                document.getElementById(br);


            }
        }

			
		}
	});
}

function populateReimbursementsResolved()
{
    fetch("http://localhost:7001/jonathanSniderProjectOne/managerListReimbursements").then(function(response) {
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
            resolvedHolder=document.getElementById("resolvedList");
            reimbursementList=data;
            for(let i=0;i<reimbursementList.length;i++)
            {
            if(reimbursementList[i].decidingManagerId!=0)
            {
                let tableRow = document.createElement("tr");
            resolvedHolder.appendChild(tableRow);

            let nameElement=document.createElement("td");
            tableRow.appendChild(nameElement);

            let name=reimbursementList[i].reimbursementName;
            let nameText = document.createTextNode(name);
            nameElement.appendChild(nameText);

            let amountElement=document.createElement("td");
            tableRow.appendChild(amountElement);
    
            let amount=reimbursementList[i].reimbursementAmount;
            let amountText =document.createTextNode(amount);
            amountElement.appendChild(amountText);

            let employeeElement=document.createElement("td");
            tableRow.appendChild(employeeElement);

            let employeeName=reimbursementList[i].employee.firstName+" "+reimbursementList[i].employee.lastName;
            let employeeText =document.createTextNode(employeeName);
            employeeElement.appendChild(employeeText);

            let approvedElement=document.createElement("td");
            tableRow.appendChild(approvedElement);
            if(reimbursementList[i].reimbursementApproved)
            {
                let approvedText =document.createTextNode("approved");
                approvedElement.appendChild(approvedText);
            }
            else
            {
                let approvedText =document.createTextNode("denied");
                approvedElement.appendChild(approvedText);
            }
            
            let decidingElement=document.createElement("td");
            tableRow.appendChild(decidingElement);
            
            let deciding=reimbursementList[i].decidingManagerId;
            let decidingText =document.createTextNode(deciding);
            decidingElement.appendChild(decidingText);
        }
    }
}
});
}
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

            let id=employeeList[i].employeeId;
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

                if(employeeList[i].manager==true)
                {

                    let isManagerText = document.createTextNode("Manager Access");
                    isManagerElement.appendChild(isManagerText);
                }
                else
                {
            let isManagerText = document.createTextNode("No Manager Access");
            isManagerElement.appendChild(isManagerText);
                }

                let jobElement=document.createElement("td");
                tableRow.appendChild(jobElement);

                let jobValue=employeeList[i].jobTitle;
                let jobText = document.createTextNode(jobValue);
                jobElement.appendChild(jobText);
                
                let userElement=document.createElement("td");
                tableRow.appendChild(userElement);

                let userValue=employeeList[i].logInUsername;
                let userText = document.createTextNode(userValue);
                userElement.appendChild(userText);

                let passwordElement=document.createElement("td");
                tableRow.appendChild(passwordElement);

                let passwordValue=employeeList[i].logInPassword;
                let passwordText = document.createTextNode(passwordValue);
                passwordElement.appendChild(passwordText); 
            }
        }
    });
}