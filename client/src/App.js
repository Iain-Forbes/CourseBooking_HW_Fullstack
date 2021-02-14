import './App.css';
import { useEffect } from 'react';
import { useState } from 'react';
import BookingsContainer from "./Containers/BookingsContainer"
import CourseContainer from "./Containers/CourseContainer"
import CustomerContainer from "./Containers/CustomerContainer"


function App() {

  const [courses, setCourses] = useState([]);
  const [bookings, setBookings] = useState([]);
  const [customer, setCustomers] = useState([]);

  const fetchCourses = () => {
    console.log("fetching courses..")
    const coursesUrl = 'http://localhost:8080/courses'

    fetch(coursesUrl)
    .then(res => res.json())
    .then(data => setCourses(data))
  }

  const fetchBookings = () => {
    console.log("fetching bookings..")
    const bookingsUrl = 'http://localhost:8080/bookings'

    fetch(bookingsUrl)
    .then(res => res.json())
    .then(data => setBookings(data))
  }

  const fetchCustomers = () => {
    console.log("fetching customers..")
    const customersUrl = 'http://localhost:8080/customers'

    fetch(customersUrl)
    .then(res => res.json())
    .then(data => setCustomers(data))
  }

  useEffect(() => {
    fetchCourses()
  }, [])

  useEffect(() => {
    fetchBookings()
  }, [])

  useEffect(() => {
    fetchCustomers()
  }, [])

  

  return (
    <>
  <header>
    <h1>Course Booking System</h1>
  </header>

    <main className="App">
      
      <div className="Booking">
      <BookingsContainer
        bookings={bookings}/>
      </div>   

     <div className="Booking">
      <CourseContainer 
      courses={courses}/>
      </div>   

      <div className="Customer">
      <CustomerContainer 
      customers={customer}/>
      </div> 

    </main>
    </>
  );
}

export default App;