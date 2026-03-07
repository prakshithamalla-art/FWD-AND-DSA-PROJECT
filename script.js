/* ============================================================
   YOUR OLD THING IS SOMEONE'S NEW TREASURE — script.js
   All data, state, and shared utilities
   ============================================================ */
'use strict';

/* ── ITEMS DATA ─────────────────────────────── */
const ITEMS = [
  {
    id: 'i1',
    title: 'Vintage Cast Iron Skillet',
    description: 'Lodge 12-inch cast iron from the 1970s. Perfectly seasoned over decades. Cooks evenly and gets better with age.',
    emoji: '🍳',
    category: 'kitchen',
    usage: 55,
    price: 1800,
    seeking: ['books', 'tools', 'clothing'],
    ownerId: 'u1',
    ownerName: 'Praks',
    ownerAvatar: '👩',
    date: '2024-02-10'
  },
  {
    id: 'i2',
    title: 'Bluetooth Mechanical Keyboard',
    description: 'Keychron K3 compact 75% layout with brown switches. USB-C + Bluetooth 5.1. Barely used — switched to laptop.',
    emoji: '⌨️',
    category: 'tech',
    usage: 20,
    price: 4500,
    seeking: ['books', 'kitchen', 'clothing'],
    ownerId: 'u1',
    ownerName: 'Praks',
    ownerAvatar: '👩',
    date: '2024-02-18'
  },
  {
    id: 'i3',
    title: 'Linen Blazer (M)',
    description: 'Uniqlo linen summer blazer in natural beige. Size M, worn twice. Perfect for casual office or weekend brunch.',
    emoji: '🧥',
    category: 'clothing',
    usage: 10,
    price: 2200,
    seeking: ['books', 'kitchen', 'tech'],
    ownerId: 'u1',
    ownerName: 'Praks',
    ownerAvatar: '👩',
    date: '2024-03-01'
  },
  {
    id: 'i4',
    title: 'Atomic Habits (Hardcover)',
    description: 'James Clear\'s bestseller in hardcover. Annotated with pen — adds personality! A book worth reading more than once.',
    emoji: '📗',
    category: 'books',
    usage: 70,
    price: 600,
    seeking: ['kitchen', 'clothing', 'tools'],
    ownerId: 'u2',
    ownerName: 'Bomm',
    ownerAvatar: '👨',
    date: '2024-01-25'
  },
  {
    id: 'i5',
    title: 'Adjustable Torque Wrench',
    description: 'Craftsman 1/2-inch drive torque wrench. 10–150 ft-lbs. Calibrated last year. All original accessories included.',
    emoji: '🔧',
    category: 'tools',
    usage: 40,
    price: 3200,
    seeking: ['tech', 'kitchen', 'books'],
    ownerId: 'u2',
    ownerName: 'Bomm',
    ownerAvatar: '👨',
    date: '2024-02-05'
  },
  {
    id: 'i6',
    title: 'Noise-Cancelling Earbuds',
    description: 'Sony WF-1000XM4 in black. Works perfectly — upgraded to the XM5. Comes with original case and all ear tips.',
    emoji: '🎧',
    category: 'tech',
    usage: 30,
    price: 5500,
    seeking: ['tools', 'books', 'clothing'],
    ownerId: 'u2',
    ownerName: 'Bomm',
    ownerAvatar: '👨',
    date: '2024-03-02'
  }
];

/* ── USERS DATA ─────────────────────────────── */
const USERS_DB = [
  {
    id: 'u1',
    name: 'Praks',
    email: 'praks@demo.com',
    password: 'praks123',
    avatar: '👩',
    joinDate: '2024-01-15'
  },
  {
    id: 'u2',
    name: 'Bomm',
    email: 'bomm@demo.com',
    password: 'bomm123',
    avatar: '👨',
    joinDate: '2024-01-20'
  }
];

/* ── AUTH ────────────────────────────────────── */
const Auth = {
  SESSION_KEY: 'ts_session',

  current() {
    try {
      const s = localStorage.getItem(this.SESSION_KEY);
      return s ? JSON.parse(s) : null;
    } catch { return null; }
  },

  login(email, password) {
    const user = USERS_DB.find(u => u.email === email.trim().toLowerCase());
    if (!user) return { ok: false, msg: 'No account found with that email.' };
    if (user.password !== password) return { ok: false, msg: 'Incorrect password. Try again.' };
    localStorage.setItem(this.SESSION_KEY, JSON.stringify(user));
    return { ok: true, user };
  },

  signup(name, email, password) {
    if (!name.trim()) return { ok: false, msg: 'Name is required.' };
    if (!email.includes('@')) return { ok: false, msg: 'Enter a valid email address.' };
    if (password.length < 6) return { ok: false, msg: 'Password must be at least 6 characters.' };
    const exists = USERS_DB.find(u => u.email === email.trim().toLowerCase());
    if (exists) return { ok: false, msg: 'An account with that email already exists.' };
    const newUser = {
      id: 'u' + Date.now(),
      name: name.trim(),
      email: email.trim().toLowerCase(),
      password,
      avatar: ['🧑','🧑‍💻','🧑‍🎨','🧑‍🔬','🧑‍🎤'][Math.floor(Math.random()*5)],
      joinDate: new Date().toISOString().split('T')[0]
    };
    USERS_DB.push(newUser);
    localStorage.setItem(this.SESSION_KEY, JSON.stringify(newUser));
    return { ok: true, user: newUser };
  },

  logout() {
    localStorage.removeItem(this.SESSION_KEY);
  },

  isLoggedIn() {
    return !!this.current();
  }
};

/* ── USER DATA (cart / wishlist / trades) ───── */
const UserData = {
  _key(userId, type) { return `ts_${userId}_${type}`; },

  get(userId, type) {
    try {
      return JSON.parse(localStorage.getItem(this._key(userId, type))) || [];
    } catch { return []; }
  },

  set(userId, type, data) {
    localStorage.setItem(this._key(userId, type), JSON.stringify(data));
  },

  // Cart
  getCart(userId)         { return this.get(userId, 'cart'); },
  addToCart(userId, id) {
    const cart = this.getCart(userId);
    if (!cart.includes(id)) { cart.push(id); this.set(userId, 'cart', cart); return true; }
    return false;
  },
  removeFromCart(userId, id) {
    const cart = this.getCart(userId).filter(x => x !== id);
    this.set(userId, 'cart', cart); return cart;
  },
  clearCart(userId)       { this.set(userId, 'cart', []); },

  // Wishlist
  getWishlist(userId)     { return this.get(userId, 'wishlist'); },
  toggleWishlist(userId, id) {
    const list = this.getWishlist(userId);
    const idx = list.indexOf(id);
    if (idx >= 0) { list.splice(idx, 1); this.set(userId, 'wishlist', list); return false; }
    list.push(id); this.set(userId, 'wishlist', list); return true;
  },
  inWishlist(userId, id)  { return this.getWishlist(userId).includes(id); },

  // Trades
  getTrades(userId)       { return this.get(userId, 'trades'); },
  addTrade(userId, trade) {
    const trades = this.getTrades(userId);
    trades.unshift(trade);
    this.set(userId, 'trades', trades);
  }
};

/* ── TOAST ───────────────────────────────────── */
const Toast = {
  stack: null,
  init() {
    if (this.stack) return;
    this.stack = document.createElement('div');
    this.stack.className = 'toast-stack';
    document.body.appendChild(this.stack);
  },
  show(msg, type = 'info', dur = 3200) {
    this.init();
    const t = document.createElement('div');
    const icons = { success:'✅', error:'❌', info:'ℹ️' };
    t.className = 'toast ' + type;
    t.innerHTML = `<span>${icons[type]||'ℹ️'}</span><span>${msg}</span>`;
    this.stack.appendChild(t);
    requestAnimationFrame(() => t.classList.add('show'));
    setTimeout(() => {
      t.classList.remove('show');
      setTimeout(() => t.remove(), 350);
    }, dur);
  }
};

/* ── HELPERS ─────────────────────────────────── */
function fmtPrice(n) {
  return '₹' + n.toLocaleString('en-IN');
}

function getItem(id) {
  return ITEMS.find(i => i.id === id);
}

function timeAgo(dateStr) {
  const d = new Date(dateStr), now = new Date();
  const diff = Math.floor((now - d) / 86400000);
  if (diff === 0) return 'Today';
  if (diff === 1) return 'Yesterday';
  if (diff < 30) return diff + ' days ago';
  return d.toLocaleDateString('en-IN', { day:'numeric', month:'short' });
}

function catLabel(cat) {
  const map = { kitchen:'🍳 Kitchen', tech:'💻 Tech', clothing:'👔 Clothing', books:'📚 Books', tools:'🔧 Tools' };
  return map[cat] || cat;
}

/* ── MODAL UTIL ──────────────────────────────── */
function openModal(id) {
  const m = document.getElementById(id);
  if (m) { m.classList.add('open'); document.body.style.overflow = 'hidden'; }
}
function closeModal(id) {
  const m = document.getElementById(id);
  if (m) { m.classList.remove('open'); document.body.style.overflow = ''; }
}

/* ── UPDATE NAV BADGES ───────────────────────── */
function updateNavBadges() {
  const user = Auth.current();
  if (!user) return;
  const cartCount = UserData.getCart(user.id).length;
  const wishCount = UserData.getWishlist(user.id).length;
  const cartBadge = document.getElementById('navCartBadge');
  const wishBadge = document.getElementById('navWishBadge');
  if (cartBadge) cartBadge.textContent = cartCount || '';
  if (wishBadge) wishBadge.textContent = wishCount || '';
  if (cartBadge) cartBadge.style.display = cartCount ? '' : 'none';
  if (wishBadge) wishBadge.style.display = wishCount ? '' : 'none';
}

/* ── PASSWORD STRENGTH ───────────────────────── */
function checkPwStrength(pw, barId, labelId) {
  let score = 0;
  if (pw.length >= 6) score++;
  if (pw.length >= 10) score++;
  if (/[A-Z]/.test(pw)) score++;
  if (/[0-9]/.test(pw)) score++;
  if (/[^A-Za-z0-9]/.test(pw)) score++;

  const segs = document.querySelectorAll('#' + barId + ' .pw-seg');
  const label = document.getElementById(labelId);
  const colors = ['', '#ef4444', '#f59e0b', '#10b981', '#4361ee'];
  const labels = ['', 'Weak', 'Fair', 'Good', 'Strong'];
  segs.forEach((s, i) => {
    s.style.background = i < Math.min(score, 4) ? colors[Math.min(score,4)] : '';
  });
  if (label) {
    label.textContent = pw ? labels[Math.min(score,4)] : '';
    label.style.color = pw ? colors[Math.min(score,4)] : '';
  }
}

/* ── INIT ON DOM READY ────────────────────────── */
document.addEventListener('DOMContentLoaded', () => {
  const user = Auth.current();

  /* Nav avatar / auth state */
  const navAvatar  = document.getElementById('navAvatar');
  const navLoginBtn = document.getElementById('navLoginBtn');
  const navProfileBtn = document.getElementById('navProfileBtn');

  if (navAvatar) {
    if (user) {
      navAvatar.textContent = user.avatar;
      navAvatar.title = user.name;
    } else {
      navAvatar.style.display = 'none';
    }
  }
  if (navLoginBtn)  navLoginBtn.style.display  = user ? 'none' : '';
  if (navProfileBtn) navProfileBtn.style.display = user ? '' : 'none';

  updateNavBadges();

  /* Close modals on overlay click */
  document.querySelectorAll('.modal-overlay').forEach(overlay => {
    overlay.addEventListener('click', e => {
      if (e.target === overlay) {
        overlay.classList.remove('open');
        document.body.style.overflow = '';
      }
    });
  });

  /* ESC to close modals */
  document.addEventListener('keydown', e => {
    if (e.key === 'Escape') {
      document.querySelectorAll('.modal-overlay.open').forEach(m => {
        m.classList.remove('open');
        document.body.style.overflow = '';
      });
    }
  });
});

/* ── EXPOSE GLOBALS ──────────────────────────── */
window.ITEMS      = ITEMS;
window.USERS_DB   = USERS_DB;
window.Auth       = Auth;
window.UserData   = UserData;
window.Toast      = Toast;
window.fmtPrice   = fmtPrice;
window.getItem    = getItem;
window.timeAgo    = timeAgo;
window.catLabel   = catLabel;
window.openModal  = openModal;
window.closeModal = closeModal;
window.updateNavBadges = updateNavBadges;
window.checkPwStrength = checkPwStrength;