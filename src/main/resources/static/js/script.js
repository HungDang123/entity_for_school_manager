const expand_btn = document.querySelector(".expand-btn");

let activeIndex;

expand_btn.addEventListener("click", () => {
    document.body.classList.toggle("collapsed");
});

const current = window.location.href;

const allLinks = document.querySelectorAll(".sidebar-links a");

allLinks.forEach((elem) => {
    elem.addEventListener("click", function () {
        const hrefLinkClick = elem.href;

        allLinks.forEach((link) => {
            if (link.href == hrefLinkClick) {
                link.classList.add("active");
            } else {
                link.classList.remove("active");
            }
        });
    });
});
// sidebar script
const events = document.getElementById("events");

let isDown = false;
let startX;
let startY;
let scrollLeft;
let scrollTop;

events.addEventListener("mousedown", (e) => {
    isDown = true;
    startX = e.pageX - events.offsetLeft;
    startY = e.pageY - events.offsetTop;
    scrollLeft = events.scrollLeft;
    scrollTop = events.scrollTop;
    events.style.cursor = "grabbing";
});

events.addEventListener("mouseleave", () => {
    isDown = false;
    events.style.cursor = "grab";
});

events.addEventListener("mouseup", () => {
    isDown = false;
    events.style.cursor = "grab";
});

document.addEventListener("mousemove", (e) => {
    if (!isDown) return;
    e.preventDefault();
    const x = e.pageX - events.offsetLeft;
    const y = e.pageY - events.offsetTop;
    const walkX = (x - startX) * 1;
    const walkY = (y - startY) * 1;
    events.scrollLeft = scrollLeft - walkX;
    events.scrollTop = scrollTop - walkY;
});

const scrollLeftButton = document.getElementById("action-button--previous");
const scrollRightButton = document.getElementById("action-button--next");

scrollLeftButton.addEventListener("click", () => {
    events.scrollBy({
        top: 0,
        left: -200,
        behavior: "smooth",
    });
});

scrollRightButton.addEventListener("click", () => {
    events.scrollBy({
        top: 0,
        left: 200,
        behavior: "smooth",
    });
});

events.addEventListener("scroll", (e) => {
    const position = events.scrollLeft;
    if (position === 0) {
        scrollLeftButton.disabled = true;
    } else {
        scrollLeftButton.disabled = false;
    }

    if (Math.round(position) === events.scrollWidth - events.clientWidth) {
        scrollRightButton.disabled = true;
    } else {
        scrollRightButton.disabled = false;
    }
});
// people table
const exportButton = document.querySelector(".export-btn");

const exportHTMLTableToCSV = (selector) => {
    // parse table for data
    const table = document.querySelector(selector);
    const rows = Array.from(table.rows);
    const teamMembers = rows.map((row) =>
        Array.from(row.cells).map(
            // if cell have multiple values use pipe symbol
            (cell) => cell.innerText.replace(/\n/g, "|")
        )
    );

    // construct CSV
    const csvContent =
        "data:text/csv;charset=utf-8," +
        teamMembers
            .map((teamMember) => Object.values(teamMember).join(","))
            .join("\n");

    // name file and download
    const encodedUri = encodeURI(csvContent);
    const link = document.createElement("a");
    link.setAttribute("href", encodedUri);
    link.setAttribute("download", "team-members.csv");
    document.body.appendChild(link);
    link.click();
};
con
exportButton.addEventListener("click", function () {
    exportHTMLTableToCSV(".table-widget > table");
});

