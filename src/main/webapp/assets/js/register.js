/**
 * 
 */

let pass1 = document.getElementById("passid");
	let pass2 = document.getElementById("cnfpassid");	let reglab = document.getElementById("reglab");
	function cnfpass() {
		if (pass1.value != pass2.value) {
			swal("Password Must Be Same!");
			return false;
		}
		return true;
	}

	//hide password must be same label:
	function invalabfn() {
		let invallab = document.getElementById("reglab");
		invallab.style.visibility = "hidden";
	}