/**
 * 
 */
 
 function displayDateTime(timeStemp) {
 
 	var dateTime = new Date(timeStemp);
 	
 	var month = dateTime.getMonth() + 1;
 	if(month < 10) month = "0" + month;
 	
 	var day = dateTime.getDay();
 	if(day < 10) day = "0" + day;
 	
 	return dateTime.getFullYear() + "."  + month + "." + day;
 }