import Tkinter as tk
from Tkinter import *
import ttk
from PIL import Image, ImageTk

root = tk.Tk()

root.winfo_toplevel().title("My_Title")
root.minsize( 800, 600)

#label = Label(root, text="Group").grid(row=0,sticky=W)
#w = Label(root, text="Helvetica", font=("Helvetica", 16))
#w.pack()
frame0  = tk.Frame(root,borderwidth=12,relief="sunken")
frame0.pack(fill=BOTH,expand=True)



frame1 = tk.Frame(frame0, width=300, height=200, background="bisque")
frame2 = tk.Frame(frame0, width = 600, height = 200, background="#b22222")

frame1.place(relx=0.13,rely=0.1,anchor="nw")
frame2.place(relx=0.5,rely=0.75, anchor="c")
frame2.pack_propagate(False)

#label
l1= Label(frame2, text="Text").place(relx=0.01,rely=0.1)

#input
e1 = Entry(frame2).place(relx=0.1,rely=0.1)

frame2.pack_propagate(False)
#combobox
box_value = StringVar()
box = ttk.Combobox(frame2, textvariable=box_value)
box.place(relx=0.5,rely=0.1)
box['values'] = ('X', 'Y', 'Z')
box.current(0)

#button
class App():
    def __init__(self):
        self.root = tk.Tk()
        #button = tk.Button(self.root, text = 'root quit', command=self.quit)
        #button.pack()     
       
     
        self.root.mainloop()

    def quit(self):
        self.root.destroy()
        
def open():
    app=App()
    
    

    
b = Button(frame0, text="New window", command=open,width=40,height=1)
b.place(relx=0.6,rely=0.05)



#pack() makes it worse

#image
image = Image.open("Koala.jpg")
image = image.resize((250,230),Image.ANTIALIAS)
photo = ImageTk.PhotoImage(image)
label = Label(frame0,image=photo)
label.image = photo # keep a reference!
label.place(relx=0.6,rely=0.15)
#w.pack()

#table
height = 5
width = 5
for i in range(3,height+3): #Rows
    for j in range(2,width+2): #Columns
        b = Label(frame0, text="kjbkjbkjbkb")
        b.grid(row=i, column=j)
        b.place(relx=i*0.06,rely=j*0.05)
        
root.mainloop()
