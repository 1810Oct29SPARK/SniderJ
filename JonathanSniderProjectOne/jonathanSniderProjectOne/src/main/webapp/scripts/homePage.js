
window.onload = function(){
	populateUser();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/jonathanSniderProjectOne/session").then(function(response) {
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
			//define behavior for user returned
			user = data;
			console.log(user);
			document.getElementById("usernameBar").innerText = "Hey, "+user.logInUsername+"!";
			//if(user.manager==true && user.employeeId !=1)
			if(user.manager && user.employeeId==1)
            {
			document.getElementById("openingText").innerText="You have Manager Access and as such can perform manager functions in the tabs above";
			let element = document.getElementById("reimbursementButton");
			element.parentNode.removeChild(element);
			}
			else if(!user.manager)
			{
				let element = document.getElementById("managerButton");
				element.parentNode.removeChild(element);
			}
		}
	});
	

	
	
}