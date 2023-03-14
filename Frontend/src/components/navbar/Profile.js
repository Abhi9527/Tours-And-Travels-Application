import React, { useState, useEffect } from "react";
import UserServices from "../../services/UserServices";

const Profile = () => {
  const [user, setUser] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Replace this with an API call to fetch user data
    UserServices.getCustomerDetails(sessionStorage.getItem("user_name")).then(
      (resp) => {
        setUser(resp.data);
      }
    );
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>Profile</h1>
      <p>
        Name: {user.firstname} {user.lastname}
      </p>
      <p>Email: {user.email}</p>
      <p>Gender: {user.gender}</p>
      <p>Mobile: {user.mobile}</p>
      <p>Date of Birth: {user.dob}</p>
    </div>
  );
};

export default Profile;
