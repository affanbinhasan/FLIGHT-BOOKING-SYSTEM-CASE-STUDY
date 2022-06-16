import React from "react";

import { BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import { Component } from 'react'
import axios from 'axios';

import './home.css';
import FlightBooking from "./FlightBooking"; 
import FlightSearch from "./FlightSearch";
import CheckIn from "./Check-In";
import ValidatedLoginForm from "./ValidatedLoginForm";


export default class Home extends Component{

  // this.state = {}
  constructor(params) {
      super();
    //   var searchUrl = 'this is a url';
    //   var bookUrl = '';
    //   var checkinUrl = '';
  }
  render(){
  return (
    <div>
        <p>eaasuup</p>
    </div>
    
  );
        }
}

