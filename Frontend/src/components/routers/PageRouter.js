import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AuthenticationService from "../../services/AuthenticationService";
import FooterNavBar from "../navbar/FooterNavBar";
import HomePage from "../navbar/HomePage";
import Login from "../navbar/Login";
import NavBar from "../navbar/NavBar";
import Profile from "../navbar/Profile";
import Signup from "../navbar/SignUp";

const PageRouter = () => {
  return (
    <div>
      {console.log("User Role", sessionStorage.getItem("user_role"))}
      {AuthenticationService.setupRequestInterceptor()}
      <Router>
        <NavBar></NavBar>
        <Routes>
          {/* Root Page */}
          <Route path="/" element={<HomePage></HomePage>}></Route>
          {/* Login Page for Authentication */}
          {/* <Route path="/login" element={<Login></Login>}></Route> */}
          <Route path="/login" element={<Login></Login>}></Route>
          <Route path="/signup" element={<Signup></Signup>}></Route>
          <Route path="/dashboard" element={<Profile></Profile>}></Route>
        </Routes>
        <FooterNavBar></FooterNavBar>
      </Router>
    </div>
  );
};

export default PageRouter;
