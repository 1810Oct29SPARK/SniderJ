window.onload = function(){
	populateReimbursements();
}

function populateReimbursements(){
	fetch("http://localhost:7001/jonathanSniderProjectOne/reimbursementLister").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/SessionMgmtDemo/login";
		} else {
			//define behavior for user returned
        reimbursementData=data;
        console.log(reimbursementData);
        let approvedHolder=document.getElementById("approvedList");
        for(let i=0;i<reimbursementData.length;i++)
    {
        let tableRow = document.createElement("tr");
        approvedHolder.appendChild(tableRow);

        let nameElement=document.createElement("td");
        tableRow.appendChild(nameElement);

        let name=reimbursementData[i].reimbursementName;
        let nameText = document.createTextNode(name);
        nameElement.appendChild(nameText);

        let amountElement=document.createElement("td");
        tableRow.appendChild(amountElement);

        let amount=reimbursementData[i].reimbursementAmount;
        let amountText =document.createTextNode(amount);
        amountElement.appendChild(amountText);



        
    }

            
            

            
		}
    });
}
