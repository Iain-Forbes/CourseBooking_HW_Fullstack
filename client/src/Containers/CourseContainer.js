import Course from "../components/Course/Course"
import CourseList from "../components/Course/CourseList"

const CourseContainer = ({courses}) => {

    return (
        <div>
            <h1>Courses</h1>
            <div className="courses">
                <CourseList courses={courses}/>
                </div>
        </div>
    )

}

export default CourseContainer;