import axios from "axios";

class AuthenticationService {
  constructor() {
    // Base Url i.e. common Url
    this.baseUrl = "http://localhost:8080/auth/";
  }

  authenticateUser(user) {
    // axios method to authenticate user and get jwt token
    return axios.post(this.baseUrl + "signin", user);
  }

  removeUserDetails() {
    // method to remove all details from session storage at logout
    sessionStorage.removeItem("user_name");
    sessionStorage.removeItem("profile_status");
    sessionStorage.removeItem("applicant_id");
    sessionStorage.removeItem("user_role");
    sessionStorage.removeItem("jwt");
  }

  storeUserDetails(userName, data) {
    //  method to store details in session storage and add jwt to the header
    this.setupRequestInterceptor();
    sessionStorage.setItem("profile_status", data.profileStatus);
    sessionStorage.setItem("user_name", userName);
    sessionStorage.setItem("user_role", data.role);
    sessionStorage.setItem("jwt", data.jwt);
  }

  setupRequestInterceptor() {
    // method that adds jwt to the header
    axios.interceptors.request.use((config) => {
      if (this.isUserLoggedIn()) {
        config.headers["Authorization"] =
          "Bearer " + sessionStorage.getItem("jwt");
      }
      return config;
    });
  }

  isUserLoggedIn() {
    // method to check whether user is logged in or not
    console.log("Check Login Status");
    let loggedIn = sessionStorage.getItem("user_name") === null ? false : true;
    return loggedIn;
  }

  getUserName() {
    // method to get user name
    return sessionStorage.getItem("user_name");
  }
}

export default new AuthenticationService();
