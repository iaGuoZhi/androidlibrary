package com.example.administrator.library1;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    private List<Book> mbooklist;
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView_name_writer;
        TextView textView_borrow_fre;
        ImageView imageView_supp;
        TextView textView_supp2;
        public ViewHolder(View view)
        {
            super(view);
            textView_name_writer=(TextView)view.findViewById(R.id.book_nawr_id);
            textView_borrow_fre=(TextView)view.findViewById(R.id.book_bor_fre_id);
            imageView_supp=(ImageView)view.findViewById(R.id.book_supp_id);
            textView_supp2=(TextView)view.findViewById(R.id.book_supp2_id);
        }
    }
    public BookAdapter(List<Book> bookList)
    {
        mbooklist=bookList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book=mbooklist.get(position);
        holder.textView_name_writer.setText(book.getName()+" "+book.getWriter());
        //holder.textView_borrow_fre.setText("借阅数："+String.valueOf(book.getFrequency()));
        //holder.textView_supp2.setText(String.valueOf(book.getRecommends()));
    }
    @Override
    public int getItemCount() {
        return mbooklist.size();
    }
}
