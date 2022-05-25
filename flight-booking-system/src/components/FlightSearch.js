

import React, { Component } from 'react'
import axios from 'axios';

const api = axios.create({
  // baseURL: 'http://localhost:9000/flight-search-ms/'
  baseURL:'http://localhost:9001/'
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
      this.setState({ flight: response.data})
      if(response === 200){
      console.log(response.data)
      
      console.log(this.state)}
      else{
        console.log("error getting data" + response.data)
      }
    })
    .catch( error => {
      console.log(error)
    })
  }

  render() {
    const {origin,destination} = this.state
    return (
      <><div>
        <h1 className="dialog-title">Search For Flights</h1>
        <div>
        <form onSubmit={this.submitHandler}>
                <br/>
                <div id='input_feild'>
                    <input class="form__field" placeholder="origin" type="text" name='origin' value={ origin } onChange={this.changeHandler} required="true"></input>
                </div>
                
                <div id='input_feild'>
                    <input class="form__field" placeholder="destination"  type="text" name='destination' value={ destination } onChange={this.changeHandler} required="true"></input>
                </div>
                {/* <div>
                    <label>Last Name - </label><input type="text" name='lastName' value={ lastName } onChange={this.changeHandler('user')} ></input>
                </div> */}
                <button type='submit'>Search</button>
            </form>
          <div id = 'searchResults' >
            {this.state.flight.map(flight => <div className='flight-info' key={flight.flight_id}>
            
                <h3>Flight id : {flight.flight_id} flight name : {flight.flight_name}    origin : {flight.flight_origin}    destination : {flight.flight_destination} duration : {flight.duration}</h3>
                <a href='localhost:3000/booking'><button>Book</button></a>
                </div>)
            }
          </div>
        </div>
        
      </div></>
    )
  }
}
