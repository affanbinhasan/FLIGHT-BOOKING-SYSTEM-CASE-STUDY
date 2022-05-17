import React from "react";

import { Link, Route } from "react-router-dom";

import './home.css';

const HomePage = () => {
    return(
        <div className="links">
            <p>n</p>
            <div>
                <a href="/search"><button>Search</button></a>
                <a href="/book"><button>Search</button></a>
                <a href="/check-in"><button>Search</button></a>
            </div>
            {/* <Link to="/search">Search</Link>
            <Link to="/book">Book</Link>
            <Link to="/check-in">Check-In</Link> */}
        </div>
    )
}

export default HomePage;