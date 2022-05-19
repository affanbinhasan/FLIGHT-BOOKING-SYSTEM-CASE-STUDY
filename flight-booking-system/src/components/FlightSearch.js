

import React, { Component } from 'react'
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:9000/flight-search-ms/'
})


export default class FlightSearch extends Component {
  // state = {
  //   flight: []
  // }

  constructor() {
    super();

    this.state = {
      origin:'',
      destination:'',
      flight: []
    }
  
    // this.state = {
    //    first
    // }
  }

  changeHandler = (event) => {
    this.setState({[event.target.name]:event.target.value})
  }
  
  submitHandler = event => {
    event.preventDefault();
    api.get('flight/getflight/' + this.state.origin+ "/" + this.state.destination)
    .then(response => {
      if(response === 200){
      console.log(response.data)
      this.setState({ flight: response.data})
      console.log(this.state)}
      else{
        console.log("error getting data" + response.statusText)
      }
    })
    .catch( error => {
      console.log(error)
    })
  }

  render() {
    const {origin,destination} = this.state
    return (
      <><div className="dialog-box">
        <h1 className="dialog-title">Search For Flights</h1>
        <div>
        <form onSubmit={this.submitHandler}>
                <br/>
                <div>
                    <label>Origin - </label><input type="text" name='origin' value={ origin } onChange={this.changeHandler} required="true"></input>
                </div>
                <div>
                    <label>Destination - </label><input type="text" name='destination' value={ destination } onChange={this.changeHandler} required="true"></input>
                </div>
                {/* <div>
                    <label>Last Name - </label><input type="text" name='lastName' value={ lastName } onChange={this.changeHandler('user')} ></input>
                </div> */}
                <button type='submit'>Book</button>
            </form>
          <div id = 'searchResults' >
          {this.state.flight.map(flight => <div className='flight-info' key={flight.flight_id}>
          
              <h3>flight name : {flight.flight_name}    origin : {flight.flight_origin}    destination : {flight.flight_destination} duration : {flight.duration}</h3>
              <a href='localhost:3000/booking'><button>Book</button></a>
          </div>)
          }
        </div>
        </div>
        
      </div></>
    )
  }
}
