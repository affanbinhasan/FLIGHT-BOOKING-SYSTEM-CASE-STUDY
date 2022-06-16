import logo from './logo.svg';
import './App.css';
import React from 'react';
import HomePage from './components/Home';
import { BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import FlightSearch from './components/FlightSearch';
import CheckIn from './components/Check-In';
import FlightBooking from './components/FlightBooking';
import ValidatedLoginForm from './components/ValidatedLoginForm';

function App() {
  var searchUrl = '/search';
  var bookUrl = '/booking';
  var checkinUrl = '/checkin';
  var logininUrl = '/login';
  // this.state = {}
  return (
    <Router>
        <div className="App" id='App'>
          {/* <p>n</p> */}
            <div id='navbar'>
                <a href={logininUrl}><button>Login</button></a>
                <a href={searchUrl}><button>Search</button></a>
                <a href={bookUrl}><button>Book</button></a>
                <a href={checkinUrl}><button>Check-In</button></a>
                <a href="/"><button>Home</button></a>
            </div>
            {/* <ValidatedLoginForm/> */}
            <div id='space'></div>
            <h1></h1>
            {/* <Login></Login> */}
            {/* <Search/> */}
            {/* <FlightSearch/> */}
            {/* <FlightBooking/> */}
            <Routes>
              <Route exact path="/login" element={<ValidatedLoginForm/>}></Route>
              <Route exact path="/search" element={<FlightSearch/>}></Route>
              <Route exact path="/booking" element={<FlightBooking/>}></Route>
              <Route exact path="checkin" element={<CheckIn/>}></Route>
            </Routes>

            {/* <div class="form__group field">
              <input type="input" class="form__field" placeholder="Name" name="name" id='name' required />
              <label for="name" class="form__label">Name</label>
            </div> */}

        </div>
        </Router>
    
  );
}

export default App;
