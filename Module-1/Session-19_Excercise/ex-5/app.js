const modal = document.getElementById('modal');
const modalShow = document.getElementById('show-modal');
const modalClose = document.getElementById('close-modal');
const bookmarkForm = document.getElementById('bookmark-form');
const websiteNameEl = document.getElementById('website-name');
const websiteUrlEl = document.getElementById('website-url');
const bookmarksContainer = document.getElementById('bookmarks-container');

let bookmarks = [];

// Hiển thị Modal
function showModal() {
    modal.classList.add('show-modal');
    websiteNameEl.focus();
}

// Đóng Modal
modalClose.addEventListener('click', () => modal.classList.remove('show-modal'));
window.addEventListener('click', (e) => (e.target === modal ? modal.classList.remove('show-modal') : false));

// Hàm lấy dữ liệu từ Local Storage
function fetchBookmarks() {
    if (localStorage.getItem('bookmarks')) {
        bookmarks = JSON.parse(localStorage.getItem('bookmarks'));
    } else {
        // Dữ liệu mẫu ban đầu nếu trống
        bookmarks = [
            { name: 'Google', url: 'https://google.com' },
        ];
        localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
    }
    buildBookmarks();
}

// Hàm Xóa Website
function deleteBookmark(url) {
    // Lọc bỏ website có url trùng khớp
    bookmarks = bookmarks.filter(bookmark => bookmark.url !== url);
    // Cập nhật lại Local Storage
    localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
    fetchBookmarks();
}

// Xây dựng giao diện danh sách Bookmark
function buildBookmarks() {
    // Xóa nội dung cũ trước khi vẽ lại
    bookmarksContainer.textContent = '';
    
    bookmarks.forEach((bookmark) => {
        const { name, url } = bookmark;
        
        // Tạo thẻ div cha cho mỗi bookmark
        const item = document.createElement('div');
        item.classList.add('bookmark-item');
        
        // Nút xóa (X)
        const closeIcon = document.createElement('i');
        closeIcon.classList.add('fas', 'fa-times', 'delete-icon');
        closeIcon.setAttribute('title', 'Delete Bookmark');
        closeIcon.setAttribute('onclick', `deleteBookmark('${url}')`);

        // Link liên kết
        const link = document.createElement('a');
        link.setAttribute('href', `${url}`);
        link.setAttribute('target', '_blank');
        link.style.color = 'white';
        link.style.textDecoration = 'none';
        link.textContent = name;

        // Thêm các phần tử vào container
        item.append(closeIcon, link);
        bookmarksContainer.appendChild(item);
    });
}

// Xử lý sự kiện khi nhấn Save (Thêm mới)
function storeBookmark(e) {
    e.preventDefault();
    const nameValue = websiteNameEl.value;
    let urlValue = websiteUrlEl.value;

    // Tự động thêm https:// nếu người dùng quên nhập
    if (!urlValue.includes('http://') && !urlValue.includes('https://')) {
        urlValue = `https://${urlValue}`;
    }

    const bookmark = {
        name: nameValue,
        url: urlValue,
    };

    bookmarks.push(bookmark);
    // Lưu vào Local Storage
    localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
    fetchBookmarks();
    bookmarkForm.reset();
    modal.classList.remove('show-modal');
}

// Event Listeners
modalShow.addEventListener('click', showModal);
bookmarkForm.addEventListener('submit', storeBookmark);

// Chạy hàm lấy dữ liệu khi trang web vừa tải xong
fetchBookmarks();