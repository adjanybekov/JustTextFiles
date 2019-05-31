/*
 * Every flight may have an arbitrary number of pre-departure procedures which must be completed prior to takeoff.
 *
 * These must happen in sequential order, since subsequent procedures may depend on previous ones.
 *   e.g. fueling, boarding of passengers, pre take-off checklist, etc.
 * Each procedure must do some work and then signal that the next procedure may begin or abort the pre-departure process should an error condition occur.
 *
 * Create a class, PreFlightCheck, which exposes two functions:
 *   addProcedure( procedureFcn ): register a procedure function, which takes a "proceed" callback and also an "abort" callback.
 *   execute( successCallback, errorCallback ): runs all procedures, then calls either the success callback, or error callback if any procedure is aborted.
 */

// var PreFlightCheck = require('./PreFlightCheck');  // <- this is the file you make;

var preFlight = new PreFlightCheck();

// PreFlightCheck should expose 
preFlight.addProcedure(function(proceed, abort) {
    // TODO ??
    var self = this.preFlight;

    setTimeout(function() {
        self.onRunway = true;
        proceed();
    }, 10);
});

preFlight.addProcedure(function(proceed, abort) {
    this.readyForBoarding = true;
    this.remainingPassengersCount = 229;
    proceed();  
});


preFlight.addProcedure(function(proceed, abort) {
    //TODO ???
    var self = this.preFlight;

    if (!self.readyForBoarding) {
        abort("Boarding attempted before plane was readyForBoarding");
    }
    var interval = setInterval(function() {
        self.remainingPassengersCount -= Math.floor(Math.random() * 20);
        if (self.remainingPassengersCount <= 0) {
            clearInterval(interval);
            proceed();
        }
    }, 20);
});



preFlight.execute(function() {
    var self = this.preFlight;
    console.log(self.readyForBoarding); // true
    console.log(self.remainingPassengersCount <= 0); // true
    console.log(self.onRunway); // true
    }, (error) => console.log("Procedure aborted, reason: " + error)
);

