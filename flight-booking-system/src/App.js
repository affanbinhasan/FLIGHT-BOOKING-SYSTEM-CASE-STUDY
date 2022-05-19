import logo from './logo.svg';
import './App.css';
import React from 'react';
import HomePage from './components/Home';
import { BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import FlightSearch from './components/FlightSearch';
import Book from './components/Book';
import CheckIn from './components/Check-In';
import FlightBooking from './components/FlightBooking';
import Search from './components/Search';

function App() {
  return (
    <Router>
        <div className="App">
          <p>n</p>
            <div>
                <a href="/search"><button>Search</button></a>
                <a href="/booking"><button>Book</button></a>
                <a href="/check-in"><button>Check-In</button></a>
            </div>
            {/* <Search/> */}
            {/* <FlightSearch/> */}
            {/* <FlightBooking/> */}
            <Routes>
              <Route exact path='/search' element={<FlightSearch/>}></Route>
              <Route exact path='/booking' element={<FlightBooking/>}></Route>
              <Route exact path='/check-in' element={<CheckIn/>}></Route>
            </Routes>

        </div>
        </Router>
    
  );
}

export default App;
