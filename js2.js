class PreFlightCheck{

	constructor(){
		this.readyForBoarding = false;
		this.remainingPassengersCount = 123;
		this.onRunway = false;

		this.allow_proceed = true;
	}

	addProcedure(procedureFcn){
		//register a procedure function
		var abort = function(str){
			console.log(str);			
		}		

		var self = this;
		var proceed = function(){
			if(self.onRunway==true && (self.readyForBoarding==false || self.remainingPassengersCount>0)){
				console.log("here ....")
				self.readyForBoarding = false;
				self.allow_proceed = false;
			}
		}

		procedureFcn(proceed, abort);
	}

	execute(successCallback, errorCallback){
		//check if all things needed to be finished before executing are done
		//return true or give an error

		var self = this;
		setTimeout(function() {
	        if (self.allow_proceed) {
				console.log("ok")
				successCallback()
			}
			else{
				console.log("fail")
				errorCallback("fail")
			}
	    }, 100);

		
	}
}
