package com.lijinfeng.eshop.service.impl;

import com.lijinfeng.eshop.dao.AddressMapper;
import com.lijinfeng.eshop.dao.OrderMapper;
import com.lijinfeng.eshop.dao.UserMapper;
import com.lijinfeng.eshop.entity.Address;
import com.lijinfeng.eshop.entity.Order;
import com.lijinfeng.eshop.entity.User;
import com.lijinfeng.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ljf-����˫�� on 2016/4/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AddressMapper addressMapper;



    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(int id) {
        userMapper.delUser(id);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void updateUserById(int id) {
        userMapper.updateUserById(id);
    }

    @Override
    public void batchDelete(int... ids) {
        // TODO Auto-generated method stub
        int[] id1 = ids;
        for(int id:id1) {
            userMapper.delUser(id);
        }
    }

    @Override
    public void batchAdd(List<User> list) {
        userMapper.batchAdd(list);
    }

    @Override
    public void batchDel(Map map) {
        // TODO Auto-generated method stub
        userMapper.batchDel(map);
    }

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    @Override
    public void pay(Order order) {
        orderMapper.add(order);
    }

    @Override
    public void batchPay(List orders) {
        orderMapper.batchAdd(orders);
    }

    @Override
    public List<Order> myOrders(String userId) {
        return orderMapper.getOrders(userId);
    }

    @Override
    public Address findDefaultAddress(String userId) {
        return addressMapper.findDefaultAddress(userId);
    }

    @Override
    public List<Address> myAddress(String userId) {
        return addressMapper.findAddressByUserId(userId);
    }

}

