#Submitted files: overview.txt, hardware.py, components.py, computers.py, testing.py (5)

from hardware import *
from computers import *
from components import *

if __name__ == "__main__":
    #Computer class
    print("Testing Computer class:")

    try:
        pc_processor = Processor("Core i5-14600", "Intel", "x86_64", "4.0", 8)
    except TypeError:
        print("Processor constructor clock speed type check test passed")

    pc_processor = Processor("Core i5-14600", "Intel", "x86_64", 4.0, 8)
    pc_storage = Storage("P1 SSD", "Crucial", "NVMe", 512)
    my_pc = Computer("XPS Desktop", "Dell", pc_processor, pc_storage)

    print(my_pc)
    print(my_pc.processor)
    print(my_pc.storage)

    if my_pc.processor.clock_speed == 4.0:
        print("Getters returned correct values for PC processor clock speed")
    else:
        print("Getters returned incorrect values for PC processor clock speed!")

    try:
        my_pc.processor = "Intel Core i5-14600"
    except TypeError:
        print("Processor setter type check test passed")



    #Laptop class
    print("\nTesting Laptop class:")

    laptop_processor = Processor("Core i5-1135G7", "Intel", "x86_64", 2.4, 4)
    laptop_storage = Storage("SN350 SSD", "WD", "NVMe", 256)
    laptop_battery = Battery("4-cell Battery", "Dell", 6930)

    try:
        my_laptop = Laptop("XPS 13", "Dell", laptop_processor, laptop_storage, "battery", "en-IE")
    except TypeError:
        print("Constructor battery type check test passed")

    my_laptop = Laptop("XPS 13", "Dell", laptop_processor, laptop_storage, laptop_battery, "en-IE")

    if my_laptop.battery.capacity == 6930:
        print("Getters returned correct values for laptop battery capacity")
    else:
        print("Getters returned incorrect values for laptop battery capacity!")

    print(my_laptop.specs)
    
    

    #Phone class
    print("\nTesting Phone class")

    phone_processor = Processor("Snapdragon 8 Gen 3", "Qualcomm", "ARM", 3.3, 8)
    phone_storage = Storage("UFS 3.1 Storage", "Samsung", "UFS 3.1", 128)
    phone_battery = Battery("Li-ion Battery", "Samsung", 4000)
    my_phone = Phone("Galaxy S24", "Samsung", phone_processor, phone_storage, phone_battery, "5G")

    try:
        my_phone.mobile_standard = 5
    except TypeError:
        print("Mobile standard setter type check test passed")
        

    print(my_phone.specs)



    #Same manufacturer method
    print("\nTesting same manufacturer method")

    print("PC (%s) has same manufacturer as laptop (%s):" % (my_pc.manufacturer, my_laptop.manufacturer))
    print(my_pc.same_manufacturer(my_laptop))

    print("PC processor (%s) has same manufacturer as laptop processor (%s):" % (my_pc.processor.manufacturer, my_laptop.processor.manufacturer))
    print(my_pc.processor.same_manufacturer(my_laptop.processor))

    print("PC (%s) has same manufacturer as phone (%s):" % (my_pc.manufacturer, my_phone.manufacturer))
    print(my_pc.same_manufacturer(my_phone))

    print("Laptop (%s) has same manufacturer as phone (%s):" % (my_laptop.manufacturer, my_phone.manufacturer))
    print(my_laptop.same_manufacturer(my_phone))

    try:
        my_laptop.same_manufacturer("phone")
    except TypeError:
        print("Same manufacturer method type check test passed")



    #Faster processor method
    print("\nTesting faster processor method")

    print("PC processor (%0.2f GHz) has higher clock speed than laptop processor (%0.2f GHz):" % (my_pc.processor.clock_speed, my_laptop.processor.clock_speed))
    print(my_pc.processor.faster(my_laptop.processor))

    print("Laptop processor (%0.2f GHz) has higher clock speed than PC processor (%0.2f GHz):" % (my_laptop.processor.clock_speed, my_pc.processor.clock_speed))
    print(my_laptop.processor.faster(my_pc.processor))

    print("Laptop processor (%0.2f GHz) has higher clock speed than phone processor (%0.2f GHz):" % (my_laptop.processor.clock_speed, my_phone.processor.clock_speed))
    print(my_laptop.processor.faster(my_phone.processor))

    print("PC processor (%0.2f GHz) has higher clock speed than phone processor (%0.2f GHz):" % (my_pc.processor.clock_speed, my_phone.processor.clock_speed))
    print(my_pc.processor.faster(my_phone.processor))

    try:
        my_pc.processor.faster(my_phone)
    except TypeError:
        print("Faster processor method type check test passed")



    #Larger storage method
    print("\nTesting larger storage method")

    print("PC (%d GB) has more storage than laptop (%d GB):" % (my_pc.storage.size, my_laptop.storage.size))
    print(my_pc.storage.larger(my_laptop.storage))

    print("Phone (%d GB) has more storage than PC (%d GB):" % (my_phone.storage.size, my_pc.storage.size))
    print(my_phone.storage.larger(my_pc.storage))

    try:
        print(my_phone.storage.larger(my_pc))
    except TypeError:
        print("Larger storage method type check test passed")



    #Bigger battery method
    print("\nTesting bigger battery method")

    print("Phone battery (%d mAh) has a larger capacity than laptop battery (%d mAh):" % (my_phone.battery.capacity, my_laptop.battery.capacity))
    print(my_phone.battery.larger_capacity(my_laptop.battery))

    print("Laptop battery (%d mAh) has a larger capacity than phone battery (%d mAh):" % (my_laptop.battery.capacity, my_phone.battery.capacity))
    print(my_laptop.battery.larger_capacity(my_phone.battery))

    try:
        print(my_laptop.battery.larger_capacity(my_pc))
    except TypeError:
        print("Bigger battery method type check test passed")



    #Overclock method
    print("\nTesting overclock method")

    try:
        my_pc.processor.overclock("20")
    except TypeError:
        print("Overclock method percentage type check test passed")

    print("Previous clock speed of PC processor: %0.2f GHz" % my_pc.processor.clock_speed)
    my_pc.processor.overclock(20)
    new_speed = my_pc.processor.clock_speed
    print("New clock speed of PC processor: %0.2f GHz" % new_speed)
    if new_speed == 4.8:
        print("New clock speed of PC set correctly by overclock method")
    else:
        print("New clock speed of PC not set correctly by overclock method!")

    print("Previous clock speed of laptop processor: %0.2f GHz" % my_laptop.processor.clock_speed)
    my_laptop.processor.overclock(30)
    new_speed = my_laptop.processor.clock_speed
    print("New clock speed of laptop processor: %0.2f GHz" % new_speed)
    if new_speed == 3.12:
        print("New clock speed of laptop set correctly by overclock method")
    else:
        print("New clock speed of laptop not set correctly by overclock method!")