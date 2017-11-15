package fr.android.androidexercises.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.android.androidexercises.R
import fr.android.androidexercises.listeners.OnItemClickedListener
import fr.android.androidexercises.models.Book
import fr.android.androidexercises.views.BookItemView

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class BookAdapterRecycler(
        private val inflater: LayoutInflater,
        private val books: List<Book>,
        private val listener: OnItemClickedListener<Book>
) : RecyclerView.Adapter<BookAdapterRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.book_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        (holder.itemView as BookItemView)
            .bindView(book) // fill view from book
            .setOnClickListener { listener.onItemClicked(book) } // add a click listener on each item view
    }

    override fun getItemCount(): Int = books.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}