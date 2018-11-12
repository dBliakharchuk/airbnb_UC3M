$(document).ready(function() {

});

function messageUser() {
	var message = prompt("Please enter your message");

}

function updateUserData() {

	var selectedUserEmail = $("#user-email").val();
	var selectedUserName = $("#user-name").val();
	var selectedUserSurname = $("#user-surname").val();
	var selectedUserPhone = $("#user-phone-number").val();

	if (selectedUserEmail != null && selectedUserEmail != "") {
		if (selectedUserName != null && selectedUserName != ""
				&& selectedUserSurname != null && selectedUserSurname != ""
				&& selectedUserPhone != null && selectedUserPhone != "") {
			$.post("/airbnb/administatorUsers", {
				action : "updateUser",
				email : selectedUserEmail,
				name : selectedUserName,
				surname : selectedUserSurname,
				phoneNumber : selectedUserPhone
			}).done(function(status) {
				if (status == 1) {
					if (alert("User data updated successfully")) {
					} else
						window.location.reload();
				} else if (status == 0)
					alert("Incorrect Data");
				else
					alert("Unknow error");
			});
		} else {
			alert("You can't leav empty fields");
		}

	} else {
		alert("User not selected");
	}
}

function changePassword() {

	var selectedUserEmail = $("#user-email").val();

	if (selectedUserEmail != null && selectedUserEmail != "") {
		var password = prompt("Please enter new password");

		if (password != null && password != "") {
			// to do get
			$.post("/airbnb/administatorUsers", {
				action : "changePassword",
				password : password,
				email : selectedUserEmail
			}).done(function(status) {
				if (status == 1)
					alert("Password updated successfully");
				else if (status == 0)
					alert("Incorrect Password");
				else
					alert("Unknow error");
			});

		}

	} else {
		alert("User not selected");
	}

}

function deleteUser() {

	var selectedUserEmail = $("#user-email").val();

	if (selectedUserEmail != null && selectedUserEmail != "") {

		if (confirm("Do you want to delete this user?")) {
			$.post("/airbnb/administatorUsers", {
				action : "deleteUser",
				email : selectedUserEmail
			}).done(function(status) {
				if (status == 1) {
					if (alert("User deleteed successfully")) {
					} else
						window.location.reload();
				} else if (status == 0)
					alert("Incorrect Data");
				else
					alert("Unknow error");
			});

		}

	} else {
		alert("User not selected");
	}

}

function deletePlace() {
	confirm("Do you want to delete this place?");
}

function showUserUpdatedInfo() {
	alert("User updated!");
}

function selectUserCell(id, elementsNumber) {

	for (var i = 0; i < elementsNumber; i++) {
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
	var phone = phone_raw.trim();

	var phoneField = cell.children[3].childNodes[0];

	console.log(email.innerText);

	document.getElementById("user-email").value = email;
	document.getElementById("user-name").value = name;
	document.getElementById("user-surname").value = surname;
	document.getElementById("user-phone-number").value = phone;

}