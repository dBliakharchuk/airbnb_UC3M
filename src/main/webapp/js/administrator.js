window.onload = function() {

};



function messageUser()
{
   var message = prompt("Please enter your message");
}


function changePassword()
{
   var password = prompt("Please enter new password");
}

function deleteUser()
{
   confirm("Do you want to delete this user?");
}

function deletePlace()
{
   confirm("Do you want to delete this place?");
}

function selectUserCell(id, elementsNumber)
{
	
	for(var i=0; i<elementsNumber;i++)
	{
		var currnet_id = "user-cel-" + i;
		var currnet_cell = document.getElementById(currnet_id);
		currnet_cell.className = "user-cel";
	}
	var cell = document.getElementById(id);
	
	cell.className = "user-cel-active";
	
	

	var email = cell.children[0].innerText;
	var name = cell.children[1].innerText;
	var surname = cell.children[2].innerText;
	var phone_raw = cell.children[3].innerHTML;
	var  phone = phone_raw.trim();
	
	var phoneField = cell.children[3].childNodes[0];
	
	console.log(email.innerText);
	
	document.getElementById("user-email").value = email ;
	document.getElementById("user-name").value = name ;
	document.getElementById("user-surname").value = surname ;
	document.getElementById("user-phone-number").value = phone ;


	
}