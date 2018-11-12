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

	document.getElementById("user-email").value = email;
	document.getElementById("user-name").value = name;
	document.getElementById("user-surname").value = surname;
	document.getElementById("user-phone-number").value = phone;

}

function selectApartmentCell(id, elementsNumber) {

	for (var i = 0; i < elementsNumber; i++) {
		var currnet_id = "place-cel-" + i;
		var currnet_cell = document.getElementById(currnet_id);
		currnet_cell.className = "place-cel";
	}
	var cell = document.getElementById(id);

	cell.className = "place-cel-active";

	var email = cell.children[0].innerText;
	var apartment_name = cell.children[1].innerText;
	var cuntry = cell.children[2].innerText;
	var price_raw = cell.children[3].innerHTML;
	var price = price_raw.trim();
	var type = cell.children[4].innerText;
	var adultsBeds = cell.children[5].innerHTML;
	var childrensBeds = cell.children[6].innerHTML;
	var descriptions = cell.children[7].innerText;

	document.getElementById("host-email").value = email;
	document.getElementById("apartment-name").value = apartment_name;

	
	// document.getElementById("user-email").value = email;
	// document.getElementById("user-name").value = name;
	// document.getElementById("user-surname").value = surname;
	// document.getElementById("user-phone-number").value = phone;

}