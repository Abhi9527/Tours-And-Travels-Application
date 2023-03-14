import axios from 'axios';


class PackageService {
    constructor() {
        this.baseUrl = "http://localhost:8080/"
    }

    addPackages(packages){
        return axios.post(this.baseUrl+"package/addpackages",packages)
    }

    updatePackages(package){
        return axios.put(this.baseUrl+"package/updatepackage",package)
    }


    deletePackage(packageId){
        return axios.delete(this.baseUrl+"package/deletePackage/"+packageId)
    }

    getAllPackages(package){
        return axios.get(this.baseUrl+"package/allpackages")
    }
}

export default new BookingServices();