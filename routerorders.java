const express = require('express');
const router = express.Router();
const Order = require('../models/Order');

// Place an order
router.post('/', async (req, res) => {
    const { userId, items, totalAmount } = req.body;
    try {
        const order = new Order({ userId, items, totalAmount });
        await order.save();
        res.status(201).json({ message: 'Order placed successfully' });
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

module.exports = router;
