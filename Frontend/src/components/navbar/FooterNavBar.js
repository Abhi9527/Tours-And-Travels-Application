// import "../../styles/NavBar.css";
// import "../../styles/commonStyle.css";
import { Link } from "react-router-dom";
import { useState } from "react";
// import AuthenticationService from "../services/AuthenticationService";

const FooterNavBar = () => {
  const ScrollToTop = () => {
    window.scrollTo(0, 0);
  };
  return (
    <div className="navbar footerBody">
      {/* <div className="footerDeclaration">
        Copyright © 2022-2023 SP Solutions Ltd. All rights reserved.
      </div>
      <div className="menuBody">
        <div className="navLinkBody">
          <Link to="/disclaimer">
            <div type="button" className="navButton" onClick={ScrollToTop}>
              Disclaimer
            </div>
          </Link>
        </div>
        <div className="navLinkBody">
          <Link to="/termsofuse">
            <div type="button" className="navButton" onClick={ScrollToTop}>
              Terms Of Use
            </div>
          </Link>
        </div>
        <div className="navLinkBody">
          <Link to="/privacypolicy">
            <div type="button" className="navButton" onClick={ScrollToTop}>
              Privacy Policy
            </div>
          </Link>
        </div>
      </div> */}
    </div>
  );
};

export default FooterNavBar;
