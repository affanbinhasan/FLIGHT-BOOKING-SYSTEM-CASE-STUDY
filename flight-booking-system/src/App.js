import logo from './logo.svg';
import './App.css';
import React from 'react';
import HomePage from './components/Home';
import { BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import Search from './components/Search';
import Book from './components/Book';
import CheckIn from './components/Check-In';

function App() {
  return (
    <Router>
        <div className="App">
          <p>n</p>
            <div>
                <a href="/search"><button>Search</button></a>
                <a href="/book"><button>Book</button></a>
                <a href="/check-in"><button>Check-In</button></a>
            </div>
            <Routes>
              <Route exact path='/search' element={<Search/>}></Route>
              <Route exact path='/book' element={<Book/>}></Route>
              <Route exact path='/check-in' element={<CheckIn/>}></Route>
            </Routes>

        </div>
        </Router>
    
  );
}

export default App;
