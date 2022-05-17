import React from "react";


const Booking = () => {
    return(
        
        <div className="dialog-box" align="center">
            <h1 className="dialog-title">Book Your Flight</h1>
            <div>
                <form>
                    <br/>
                    <h2>First Name :    </h2> <input></input> <br/><br/><br/>
                    <h2>Last Name :   </h2> <input></input><br/><br/><br/>
                    <h2>Gender :   </h2> <input></input><br/><br/><br/>
                    <h2>Contact :   </h2> <input></input><br/><br/><br/>
                    <button>Book</button>
                </form>
            </div>
        </div>
        
    )
}

export default Booking;