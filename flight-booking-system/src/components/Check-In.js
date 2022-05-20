import React from "react";
import axios from 'axios';

const api = axios.create({
    // baseURL: 'http://localhost:9000/flight-check-in-ms/flight-check-in'
    baseURL: "http://localhost:9003/flight-check-in"
})

export class CheckIn extends React.Component{
    constructor(props) {
        super(props)
        
        this.state = {
            ref_id:'',
            checkin: []

        }
      }
  
      changeHandler = (event) => {
          this.setState({[event.target.name]: event.target.value})
      }
  
      submitHandler = event => {
          event.preventDefault();
          console.log('id is = ' + this.state.ref_id );
          api.get("/check-in/"+this.state.ref_id)
          .then( response => { 
              
                this.setState({checkin : response.data })
                console.log("below is data")
                // console.log(this.state.checkin)
                
              
            console.log(response);
            } )
          .catch( error => { console.log(error)})

        //   console.log(this.state.checkin)
      }
  
    render() {
    const {ref_id} = this.state
      
    return(
        <div className="dialog-box" align="centre">
            <h1 className="dialog-title">Check-In</h1>
            <div >
            <form onSubmit={this.submitHandler}>
                <br/>
                <div>
                    <label>Booking Reference ID - </label><input type="ref_id" name='ref_id' value={ ref_id } onChange={this.changeHandler} required="true"></input>
                </div>
                
                {/* <div>
                    <label>Last Name - </label><input type="text" name='lastName' value={ lastName } onChange={this.changeHandler('user')} ></input>
                </div> */}
                <button type='submit'>Check-In</button>
            </form>
            </div>
            <div id = 'CheckInResults'>
          {this.state.checkin.map(checkin => <div className='check-in-info' key={checkin.checkInId}>
          
              <h3>Thank You for Checking In Your Seat Number is : {checkin.seatNo}</h3>
              
          </div>)
          }
        </div>
        </div>
    )
}}

export default CheckIn