import axios from 'axios';


class PassengerServices {
    constructor() {
        this.baseUrl = "http://localhost:8080/"
    }
	
    
    addPassenger(passanger){
        return axios.post(this.baseUrl+"passenger/addPassenger",passanger)
    }

    updatePassenger(passenger){
        return axios.put(this.baseUrl+"passenger/updatePassenger",passenger)
    }


    deletePassenger(passenger){
        return axios.delete(this.baseUrl+"passenger/deletePassenger/"+passenger)
    }

    getAllPassenger(){
        return axios.post(this.baseUrl+"passenger/allPassenger")
    }

}

export default new PassengerServices();