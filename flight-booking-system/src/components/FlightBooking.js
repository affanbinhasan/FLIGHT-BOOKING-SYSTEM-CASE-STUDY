import React, { Component } from 'react'
import axios from 'axios';

export class FlightBooking extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         firstName:'',
         lastName:'',
         gender:'',
         contact:'',
      }
    }

    changeHandler = (event) => {
        this.setState({[event.target.name]: event.target.value})
    }

    submitHandler = event => {
        event.preventDefault();
        console.log(this.state)
    }

    render() {
    const {firstName,lastName,gender,contact } = this.state
    return (
        <div>
            <form onSubmit={this.submitHandler}>
                <br/>
                <div>
                    <label>Flight Id - </label><input type="text" name = "flight_id" value={ firstName } onChange={this.changeHandler} required = "true"></input>
                </div>
                <div>
                    <label>First Name - </label><input type="text" name = "firstName" value={ firstName } onChange={this.changeHandler} required = "true"></input>
                </div>
                <div>
                    <label>Last Name - </label><input type="text" name = "lastName" value={ lastName } onChange={this.changeHandler} required = "true"></input>
                </div>
                <div>
                    <label>Gender - </label><input type="text" name = "gender" value={ gender } onChange={this.changeHandler} required = "true"></input>
                </div>
                <div>
                    <label>contact - </label><input type="text" name = "contact" value={ contact } onChange={this.changeHandler} required = "true"></input>
                </div>
                <button type='submit'>Book</button>
            </form>
        </div>
    )
    }
}

export default FlightBooking