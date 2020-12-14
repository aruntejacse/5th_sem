bucket_size=int(input("ENTER THE BUCKET SIZE : "))
out_rate=int(input("ENTER THE OUTGOING RATE : "))
if out_rate>bucket_size :
    print("\n\n OUTGOING RATE SHOULD BE LESS THAN BUCKET SIZE")
else:
    n=int(input("\n\nENTER THE NUMBER OF PACKETS : "))
    stored=0
    for i in range(0,n):
        print("Packet:",i)
        inc_pack_size=int(input("\nENTER THE PACKET SIZE : "))
        if inc_pack_size > (bucket_size - stored):
            print("Bucket overflow")
        elif inc_pack_size > out_rate:
            stored+=inc_pack_size
            print("Bucket output successful")
            print("Bytes outputted:", out_rate)
            print("Last bytes sent:", inc_pack_size - out_rate)
        elif inc_pack_size<=(bucket_size-stored):
            stored+=inc_pack_size
            print("Bucket output successful")
            print("Last bytes sent:", inc_pack_size)
        stored-=out_rate

