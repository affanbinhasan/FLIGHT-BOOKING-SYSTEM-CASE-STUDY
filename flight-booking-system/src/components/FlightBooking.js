import React, { Component } from 'react'
import axios from 'axios';

const api = axios.create({
    // baseURL: 'http://localhost:9000/flight-booking-ms/booking'
    baseURL: "http://localhost:9002/booking"
})

export class FlightBooking extends Component {
    constructor() {
      super()
      this.state = {
            id : {
                flight_id:''
            },
            user : {
                firstName:'',
                lastName:'',
                gender:'',
                contact:'',
                date_of_journey: ''
            },
            booking_id: '',
            bookingStr:'',
      }
    }

    // Component = (props) => {
    //     return(
    //         this.setState()
    //     )
    // }
    // changeState = (props) => {
    //     this.setState({flight_id : props.flight_id})
    // }

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
        console.log('id is = ' + this.state.flight_id );
        api.post("/book/"+this.state.id.flight_id , this.state.user)
        .then( response => { 
            this.setState({booking_id : response.data})
            console.log(response.data)
            console.log(this.state.booking_id)
        })
        .catch( error => { console.log(error)})

        this.setState({bookingStr: 'Your Booking ID is ' + this.state.booking_id})
    }

    render() {

        console.log(this.props.id)

        const {flight_id,firstName,lastName,gender,contact,date_of_journey} = this.state
    
        return (
            <div>
                <h1 className="dialog-title">Book Your Flight</h1>
                <form onSubmit={this.submitHandler}>
                    <br/>
                    <div id='input_feild'>
                        <input class="form__field" placeholder="flight id" type="text" name='flight_id' value={ flight_id } onChange={this.changeHandler('id')} ></input>
                    </div>
                    <div id='input_feild'>
                        <input class="form__field" placeholder="first name" type="text" name='firstName' value={ firstName } onChange={this.changeHandler('user')} ></input>
                    </div>
                    <div id='input_feild'>
                        <input class="form__field" placeholder="last name" type="text" name='lastName' value={ lastName } onChange={this.changeHandler('user')} ></input>
                    </div>
                    <div id='input_feild'>
                    <input class="form__field" placeholder="gender" type="text" name='gender' value={ gender } onChange={this.changeHandler('user')} ></input>
                    </div>
                    <div id='input_feild'>
                        <input class="form__field" placeholder="contact" type="text" name='contact' value={ contact } onChange={this.changeHandler('user')}></input>
                    </div>
                    <div id='input_feild'>
                        <input class="form__field" placeholder="date of journey" type="date" name='date_of_journey' value={ date_of_journey } onChange={this.changeHandler('user')}></input>
                    </div>
                    <button type='submit'>Book</button>
                </form>
                <div>
                    <h1>{this.state.booking_id}</h1>
                </div>
            </div>
        )
    }
}

export default FlightBooking;