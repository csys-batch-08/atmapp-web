/**
 * 
 */

let pass1 = document.getElementById("passid");
	let pass2 = document.getElementById("cnfpassid");
	let reglab = document.getElementById("reglab");
	function cnfpass() {
		if (pass1.value != pass2.value) {
			pass1.style.borderBlockColor = "red";
			pass2.style.borderBlockColor = "red";
			reglab.style.visibility = "visible";
			return false;
		}
		return true;
	}

	//hide password must be same label:
	function invalabfn() {
		let invallab = document.getElementById("reglab");
		invallab.style.visibility = "hidden";
	}