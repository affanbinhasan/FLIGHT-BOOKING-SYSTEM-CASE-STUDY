import React, { Component } from 'react'
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:9000/flight-booking-ms/booking'
    // baseURL: "http://localhost:9002/booking"
})

export class FlightBooking extends Component {
    constructor(props) {
      super(props)
      
      this.state = {
            id : {
                flight_id:''
            },
            user : {
                firstName:'',
                lastName:'',
                gender:'',
                contact:'',
            }
      }
    }

    changeHandler = (obj) => event => {
        const category = {...this.state[obj]}
        const key = event.target.name;
        const value = event.target.value;

        
        category[key] = value;
        // [key] = value;

        this.setState({[obj]: category})
    }

    submitHandler = event => {
        event.preventDefault();
        console.log('id is = ' + this.state.id.flight_id );
        console.log(this.state.user);
        api.post("/book/"+this.state.id.flight_id , this.state.user)
        .then( response => { console.log(response.status) })
        .catch( error => { console.log(error)})
    }

    render() {
    const {flight_id,firstName,lastName,gender,contact} = this.state
    
    return (
        <div>
            <form onSubmit={this.submitHandler}>
                <br/>
                <div>
                    <label>Flight Id - </label><input type="text" name='flight_id' value={ flight_id } onChange={this.changeHandler('id')} ></input>
                </div>
                <div>
                    <label>First Name - </label><input type="text" name='firstName' value={ firstName } onChange={this.changeHandler('user')} ></input>
                </div>
                <div>
                    <label>Last Name - </label><input type="text" name='lastName' value={ lastName } onChange={this.changeHandler('user')} ></input>
                </div>
                <div>
                    <label>Gender - </label><input type="text" name='gender' value={ gender } onChange={this.changeHandler('user')} ></input>
                </div>
                <div>
                    <label>contact - </label><input type="text" name='contact' value={ contact } onChange={this.changeHandler('user')}></input>
                </div>
                <button type='submit'>Book</button>
            </form>
        </div>
    )
    }
}

export default FlightBooking