import axios from 'axios';


class BookingServices {
    constructor() {
        this.baseUrl = "http://localhost:8080/"
    }

    bookPackage(packageId,booking){
        return axios.post(this.baseUrl+"booking/bookpackage/"+packageId,booking)
    }

    deletePackage(bookingId){
        return axios.delete(this.baseUrl+"booking/deletePackage/"+bookingId)
    }

    getAllBookings(){
        return axios.get(this.baseUrl+"booking/allbooking")
    }
}

export default new BookingServices();