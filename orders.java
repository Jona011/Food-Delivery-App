const mongoose = require('mongoose');

const orderSchema = new mongoose.Schema({
    userId: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
    items: [
        {
            menuItemId: { type: mongoose.Schema.Types.ObjectId, ref: 'MenuItem', required: true },
            quantity: { type: Number, required: true }
        }
    ],
    totalAmount: { type: Number, required: true },
    status: { type: String, default: 'Pending' }
});

module.exports = mongoose.model('Order', orderSchema);
