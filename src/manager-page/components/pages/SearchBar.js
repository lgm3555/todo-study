import React, { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "./SearchBar.scss";

function SearchBar() {
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [searchKeyword, setSearchKeyword] = useState("");

    const handleStartDateChange = (date) => {
        setStartDate(date);
    };

    const handleEndDateChange = (date) => {
        setEndDate(date);
    };

    const handleSearchKeywordChange = (e) => {
        setSearchKeyword(e.target.value);
    };

    const handleSearch = () => {
        console.log(`Search keyword: ${searchKeyword}`);
        console.log(`Start date: ${startDate}`);
        console.log(`End date: ${endDate}`);
    };

    return (
        <div className="search_bar">
            <div className="search_bar__form">
                <div className="search_bar__form_input">
                    <label htmlFor="search_input">키워드</label>
                    <input
                        id="search_input"
                        type="text"
                        value={searchKeyword}
                        onChange={handleSearchKeywordChange}
                    />
                </div>
                <div className="search_bar__form_input">
                    <label htmlFor="start_date">시작일</label>
                    <DatePicker
                        id="start_date"
                        onChange={handleStartDateChange}
                        dateFormat="yyyy-MM-dd"
                        selected={startDate}
                        isClearable
                    />
                </div>
                <span className="no_label">~</span>
                <div className="search_bar__form_input">
                    <label htmlFor="end_date">종료일</label>
                    <DatePicker
                        id="end_date"
                        onChange={handleEndDateChange}
                        dateFormat="yyyy-MM-dd"
                        selected={endDate}
                        isClearable
                    />
                </div>
                <button className="search_bar__form_button no_label" onClick={handleSearch}>
                    검색
                </button>
            </div>
        </div>
    );
}

export default SearchBar;