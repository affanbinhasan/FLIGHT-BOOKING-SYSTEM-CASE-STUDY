import React from "react";


const Search = () => {
    return(
        
        <div className="dialog-box">
            <h1 className="dialog-title">Search For Flights</h1>
            <div>
                <form>
                    <br/>
                    <h2>Origin :    </h2> <input></input> <br/><br/><br/>
                    <h2>Destination :   </h2> <input></input><br/><br/><br/>
                    <h2>Date of Journey :   </h2> <input></input><br/><br/><br/>
                    <button>Get Flights</button>
                </form>
            </div>
        </div>
        
    )
}

export default Search;