// import React from "react";
import axios from 'axios';

import React, { Component } from 'react'

const api = axios.create({
    baseURL:"http://localhost:9000/flight-search-ms/flight/"
})

export class Search extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         flightSearch:[]
      }
    }

    componentDidMount() {
        api.get("admin/getflight")
        .then(response => {
            console.log(response)
            this.setState({flightSearch: response.data})
        })
        .catch(error => console.log(error))
    }

    render() {
        const { flightSearch } = this.state;
    return (
        <div>
            <h2>List of Flights</h2>
            {flightSearch.map(flight => <><div key={flight.flight_id}>flight name : {flight.flight_name}</div></>)}
        </div>
            
            
    )
    }
}

export default Search

















// const Search = () => {
//     return(
        
//         <div className="dialog-box">
//             <h1 className="dialog-title">Search For Flights</h1>
//             <div>
//                 <form>
//                     <br/>
//                     <h2>Origin :    </h2> <input></input> <br/><br/><br/>
//                     <h2>Destination :   </h2> <input></input><br/><br/><br/>
//                     <h2>Date of Journey :   </h2> <input></input><br/><br/><br/>
//                     <button>Get Flights</button>
//                 </form>
//             </div>
//         </div>
        
//     )
// }

// export default Search;