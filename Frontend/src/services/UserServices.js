import axios from "axios";

class UserServices {
  constructor() {
    this.baseUrl = "http://localhost:8080/";
  }

  createCustomerDetails(user, userName) {
    return axios.post(
      this.baseUrl + "customer/" + userName + "/createprofile",
      user
    );
  }

  getCustomerDetails(userName) {
    return axios.get(this.baseUrl + "customer/profile", userName);
  }

  getNameByUserName(userName) {
    return axios.get(this.baseUrl + "customer/name/" + userName);
  }

  sendPassChangeOTP(userName) {
    return axios.post(this.baseUrl + "email/forgot_password/" + userName);
  }

  verifyOTPAndChangePass(newPassDetails) {
    return axios.post(this.baseUrl + "auth/change_password", newPassDetails);
  }

  createAdminDetails(user, userName) {
    return axios.post(
      this.baseUrl + "admin/" + userName + "/createprofile",
      user
    );
  }

  getAllAdmin() {
    return axios.get(this.baseUrl + "admin/alladmindetails");
  }

  getAdminDetails(userName) {
    return axios.get(this.baseUrl + "admin/profile" + userName);
  }

  getAllCustomers() {
    return axios.get(this.baseUrl + "customer/view");
  }

  getAdminName(userName) {
    return axios.get(this.baseUrl + "admin//name/" + userName);
  }

  getCustomerName(userName) {
    return axios.get(this.baseUrl + "customer/name/" + userName);
  }

  signUpUser(cred) {
    return axios.post(this.baseUrl + "auth/signup", cred);
  }

  allBookings() {
    return axios.get(this.baseUrl + "booking/allbookings");
  }
}

export default new UserServices();
