/**
 * 
 */


let pass1 = document.getElementById("pininpid");
let pass2 = document.getElementById("pininpid1");
let reglab = document.getElementById("reglab");
function cnfpass() {
	if (pass1.value != pass2.value) {
		pass1.style.borderBlockColor = "red";
		pass2.style.borderBlockColor = "red";
		reglab.style.color = "red";
		reglab.style.visibility = "visible";
		return false;
	}
	return true;
}

//hiding lab function:
	function invalabfn() {
		let invallab = document.getElementById("reglab");
		pass1.style.borderBlockColor = "black";
		pass2.style.borderBlockColor = "black";
		invallab.style.visibility = "hidden";
	}
	
	//timeout function:
	let th = document.getElementById("timehead");
let time = 70;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("logOut.jsp");
		}
	},1000);
	
});
