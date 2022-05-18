

import React, { Component } from 'react'
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:9000/flight-search-ms/'
})


export default class FlightSearch extends Component {
  state = {
    flight: []
  }

  constructor() {
    super();
    
    api.get('flight/admin/getflight').then(response => {
      console.log(response.data)
      this.setState({ flight: response.data})
    })
    // this.state = {
    //    first
    // }
  }

  

  render() {
    return (
      <><div className="dialog-box">
        <h1 className="dialog-title">Search For Flights</h1>
        <div>
          <form>
            <br />
            <h2>Origin: </h2> <input></input> <br /><br />
            <h2>Destination: </h2> <input></input><br /><br />
            <h2>Date of Journey: </h2> <input></input><br /><br />
            <button>Get Flights</button>
          </form>
          <div>
          {this.state.flight.map(flight => <div className='flight-info' key={flight.flight_id}>
          
              <h3>flight name : {flight.flight_name}    origin : {flight.flight_origin}    destination : {flight.flight_destination} duration : {flight.duration}</h3>
              <a href='localhost:3000/booking'><button>Book</button></a>
          </div>)}
        </div>
        </div>
        
      </div></>
    )
  }
}
